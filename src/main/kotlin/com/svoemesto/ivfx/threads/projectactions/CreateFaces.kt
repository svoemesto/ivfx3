package com.svoemesto.ivfx.threads.projectactions

import com.google.gson.GsonBuilder
import com.svoemesto.ivfx.controllers.FaceController
import com.svoemesto.ivfx.controllers.FrameController
import com.svoemesto.ivfx.controllers.PersonController
import com.svoemesto.ivfx.models.Frame
import com.svoemesto.ivfx.modelsext.FaceExtJson
import com.svoemesto.ivfx.modelsext.FileExt
import com.svoemesto.ivfx.modelsext.FrameExt
import javafx.application.Platform
import javafx.scene.control.Label
import javafx.scene.control.ProgressBar
import javafx.scene.control.TableView
import java.io.FileReader
import java.io.IOException
import java.io.File as IOFile

class CreateFaces(var fileExt: FileExt,
                  val table: TableView<FileExt>,
                  val textLbl1: String,
                  val numCurrentThread: Int,
                  val countThreads: Int,
                  var lbl1: Label, var pb1: ProgressBar,
                  var lbl2: Label, var pb2: ProgressBar): Thread(), Runnable {

    override fun run() {

        lbl1.isVisible = true
        pb1.isVisible = true
        lbl2.isVisible = true
        pb2.isVisible = true

        val builder = GsonBuilder()
        val gson = builder.create()

        val pathToJsonFaces = fileExt.folderFramesFull + IOFile.separator + "faces.json"

        var countBlocks = 1
        var currentBlock = 1

        try {
            FileReader(pathToJsonFaces).use { fileReader ->
                val facesExtJsonArray: Array<FaceExtJson> = gson.fromJson(fileReader, Array<FaceExtJson>::class.java)
                val nonPerson = PersonController.getNonpersonExt(fileExt.projectExt)
                val undefindedPerson = PersonController.getUndefindedExt(fileExt.projectExt)
                for ((i, faceExtJson) in facesExtJsonArray.withIndex()) {

                    val initProgress1: Double = (numCurrentThread-1) / (countThreads.toDouble())
                    val onePeaceOfProgress: Double = 1 / (countThreads.toDouble())
                    val percentage2: Double = ((currentBlock-1) + (i+1)/facesExtJsonArray.size.toDouble() ) / countBlocks.toDouble()
                    val percentage1: Double = initProgress1 + (onePeaceOfProgress * percentage2)
                    Platform.runLater {
                        lbl1.text = textLbl1
                        pb1.progress = percentage1
                        lbl2.text = "Create face [$i/${facesExtJsonArray.size}]"
                        pb2.progress = percentage2
                    }

                    FaceController.createOrUpdate(faceExtJson, fileExt, undefindedPerson, nonPerson)

                }

            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        fileExt.hasCreatedFaces = true
//        fileExt.hasCreatedFacesString = "???"
        table.refresh()

        lbl1.isVisible = false
        lbl2.isVisible = false
        pb1.isVisible = false
        pb2.isVisible = false

    }
}
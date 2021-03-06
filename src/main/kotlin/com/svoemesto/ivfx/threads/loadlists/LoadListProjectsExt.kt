package com.svoemesto.ivfx.threads.loadlists

import com.svoemesto.ivfx.Main
import com.svoemesto.ivfx.modelsext.FileExt
import com.svoemesto.ivfx.modelsext.ProjectExt
import javafx.application.Platform
import javafx.beans.property.SimpleBooleanProperty
import javafx.collections.ObservableList
import javafx.scene.control.Label
import javafx.scene.control.ProgressBar

class LoadListProjectsExt(private var list: ObservableList<ProjectExt>,
                          private var pb: ProgressBar?,
                          private var lbl: Label?,
                          private val flagIsDone: SimpleBooleanProperty = SimpleBooleanProperty(false)
                        ) : Thread(), Runnable {

    override fun run() {
        this.name = "LoadListProjectsExt"
        loadList()
        flagIsDone.set(true)
    }

    private fun loadList() {
        val sourceIterable = Main.projectRepo.findByOrderGreaterThanOrderByOrder(0)
        list.clear()
        Platform.runLater {
            if (pb != null) pb!!.isVisible = true
            if (lbl != null) lbl!!.isVisible = true
        }
        for ((i, project) in sourceIterable.withIndex()) {
            if (!currentThread().isInterrupted) {
                Platform.runLater {
                    if (pb!=null) pb!!.progress = i.toDouble()/sourceIterable.count()
                    if (lbl!=null) lbl!!.text = "${java.lang.String.format("[%.0f%%]", i.toDouble()/sourceIterable.count())} Loading: ${project.name} ($i/${sourceIterable.count()})"
                }
                val projectExt = ProjectExt(project)
                list.add(projectExt)
            } else {
                return
            }

        }
        Platform.runLater {
            if (pb!=null) pb!!.isVisible = false
            if (lbl!=null) lbl!!.isVisible = false
        }
    }
}
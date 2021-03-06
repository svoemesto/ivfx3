package com.svoemesto.ivfx.modelsext

import com.svoemesto.ivfx.controllers.FileController
import com.svoemesto.ivfx.controllers.FrameController
import com.svoemesto.ivfx.models.File
import javafx.collections.FXCollections
import javafx.collections.ObservableList

data class FileExt(val file: File, val projectExt: ProjectExt) : Comparable<FileExt> {
    val fileName: String get() = file.name
    val fileOrder: Int get() = file.order
    var fps: Double = -1.0
        get() {
            if (field < 0) field = FileController.getFps(file)
            return field
        }
    var framesCount: Int = -1
        get() {
            if (field < 0) field = FileController.getFramesCount(file)
            return field
        }
    var folderPreview: String? = null
        get() {
            if (field == null) field = FileController.getFolderPreview(this)
            return field
        }
    var folderLossless: String? = null
        get() {
            if (field == null) field = FileController.getFolderLossless(this)
            return field
        }
    var folderConcat: String? = null
        get() {
            if (field == null) field = FileController.getFolderConcat(this)
            return field
        }
    var folderFavorites: String? = null
        get() {
            if (field == null) field = FileController.getFolderFavorites(this)
            return field
        }
    var folderShots: String? = null
        get() {
            if (field == null) field = FileController.getFolderShots(this)
            return field
        }
    var folderFramesSmall: String? = null
        get() {
            if (field == null) field = FileController.getFolderFramesSmall(this)
            return field
        }
    var folderFramesMedium: String? = null
        get() {
            if (field == null) field = FileController.getFolderFramesMedium(this)
            return field
        }
    var folderFramesFull: String? = null
        get() {
            if (field == null) field = FileController.getFolderFramesFull(this)
            return field
        }
    var folderFacesFull: String? = null
        get() {
            if (field == null) field = FileController.getFolderFacesFull(this)
            return field
        }
    var folderFacesPreview: String? = null
        get() {
            if (field == null) field = FileController.getFolderFacesPreview(this)
            return field
        }
    var folderShotsCompressedWithAudio: String? = null
        get() {
            if (field == null) field = FileController.getFolderShotsCompressedWithAudio(this)
            return field
        }
    var folderShotsLosslessWithAudio: String? = null
        get() {
            if (field == null) field = FileController.getFolderShotsLosslessWithAudio(this)
            return field
        }
    var folderShotsLosslessWithoutAudio: String? = null
        get() {
            if (field == null) field = FileController.getFolderShotsLosslessWithoutAudio(this)
            return field
        }
    var pathToLosslessFile: String? = null
        get() {
            if (field == null) field = FileController.getLossless(this)
            return field
        }
    var pathToPreviewFile: String? = null
        get() {
            if (field == null) field = FileController.getPreview(this)
            return field
        }
    var hasPreview: Boolean? = null
        get() {
            if (field == null) field = FileController.hasPreview(this)
            return field
        }
    val hasPreviewString: String get() = if (hasPreview!!) "???" else "???"
    var hasLossless: Boolean? = null
        get() {
            if (field == null) field = FileController.hasLossless(this)
            return field
        }
    val hasLosslessString: String get() = if (hasLossless!!) "???" else "???"
    var hasFramesSmall: Boolean? = null
        get() {
            if (field == null) field = FileController.hasFramesSmall(this)
            return field
        }
    val hasFramesSmallString: String get() = if (hasFramesSmall!!) "???" else "???"
    var hasFramesMedium: Boolean? = null
        get() {
            if (field == null) field = FileController.hasFramesMedium(this)
            return field
        }
    val hasFramesMediumString: String get() = if (hasFramesMedium!!) "???" else "???"
    var hasFramesFull: Boolean? = null
        get() {
            if (field == null) field = FileController.hasFramesFull(this)
            return field
        }
    val hasFramesFullString: String get() = if (hasFramesFull!!) "???" else "???"
    var hasAnalyzedFrames: Boolean? = null
        get() {
            if (field == null) field = FileController.hasAnalyzedFrames(file)
            return field
        }
    val hasAnalyzedFramesString: String get() = if (hasAnalyzedFrames!!) "???" else "???"
    var hasCreatedShots: Boolean? = null
        get() {
            if (field == null) field = FileController.hasCreatedShots(file)
            return field
        }
    val hasCreatedShotsString: String get() = if (hasCreatedShots!!) "???" else "???"
    var hasDetectedFaces: Boolean? = null
        get() {
            if (field == null) field = FileController.hasDetectedFaces(this)
            return field
        }
    val hasDetectedFacesString: String get() = if (hasDetectedFaces!!) "???" else "???"
    var hasCreatedFaces: Boolean? = null
        get() {
            if (field == null) field = FileController.hasCreatedFaces(file)
            return field
        }
    val hasCreatedFacesString: String get() = if (hasCreatedFaces!!) "???" else "???"
    var hasCreatedFacesPreview: Boolean? = null
        get() {
            if (field == null) field = FileController.hasCreatedFacesPreview(this)
            return field
        }
    val hasCreatedFacesPreviewString: String get() = if (hasCreatedFacesPreview!!) "???" else "???"
    var hasRecognizedFaces: Boolean? = null
        get() {
            if (field == null) field = FileController.hasRecognizedFaces(file)
            return field
        }
    val hasRecognizedFacesString: String get() = if (hasRecognizedFaces!!) "???" else "???"
    var hasShotsCompressedWithAudio: Boolean? = null
        get() {
            if (field == null) field = FileController.hasShotsCompressedWithAudio(this)
            return field
        }
    val hasShotsCompressedWithAudioString: String get() = if (hasShotsCompressedWithAudio!!) "???" else "???"
    var hasShotsLosslessWithAudio: Boolean? = null
        get() {
            if (field == null) field = FileController.hasShotsLosslessWithAudio(this)
            return field
        }
    val hasShotsLosslessWithAudioString: String get() = if (hasShotsLosslessWithAudio!!) "???" else "???"
    var hasShotsLosslessWithoutAudio: Boolean? = null
        get() {
            if (field == null) field = FileController.hasShotsLosslessWithoutAudio(this)
            return field
        }
    val hasShotsLosslessWithoutAudioString: String get() = if (hasShotsLosslessWithoutAudio!!) "???" else "???"
    var hasConcat: Boolean? = null
        get() {
            if (field == null) field = FileController.hasConcat(this)
            return field
        }
    val hasConcatString: String get() = if (hasConcat!!) "???" else "???"
    @Transient
    var framesExt: ObservableList<FrameExt> = FXCollections.observableArrayList()
    @Transient
    var shotsExt: ObservableList<ShotExt> = FXCollections.observableArrayList()
    @Transient
    var scenesExt: ObservableList<SceneExt> = FXCollections.observableArrayList()
    @Transient
    var eventsExt: ObservableList<EventExt> = FXCollections.observableArrayList()
    @Transient
    var facesExt: ObservableList<FaceExt> = FXCollections.observableArrayList()
    @Transient
    var framesWithFaces: MutableSet<Int> = FileController.getFramesWithFaces(file)


    fun resetFieldsLinkedShortName() {
        folderPreview = null
        folderLossless = null
        folderFavorites = null
        folderShots = null
        folderFramesSmall = null
        folderFramesMedium = null
        folderFramesFull = null
        pathToLosslessFile = null
        pathToPreviewFile = null
        hasPreview = null
        hasLossless = null
        hasFramesSmall = null
        hasFramesMedium = null
        hasFramesFull = null
        hasAnalyzedFrames = null
        hasCreatedShots = null
        hasDetectedFaces = null
        hasCreatedFaces = null
        hasShotsCompressedWithAudio = null
        hasShotsLosslessWithAudio = null
        hasShotsLosslessWithoutAudio = null
    }

    fun resetFieldsLinkedPath() {
        fps = -1.0
        framesCount = -1
    }
    override fun compareTo(other: FileExt): Int {
        return this.fileOrder - other.fileOrder
    }

}
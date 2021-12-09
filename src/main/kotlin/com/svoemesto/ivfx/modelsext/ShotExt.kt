package com.svoemesto.ivfx.modelsext

import com.svoemesto.ivfx.models.Shot
import com.svoemesto.ivfx.utils.ConvertToFxImage
import com.svoemesto.ivfx.utils.IvfxFFmpegUtils.Companion.convertDurationToString
import com.svoemesto.ivfx.utils.IvfxFFmpegUtils.Companion.getDurationByFrameNumber
import com.svoemesto.ivfx.utils.OverlayImage.Companion.setOverlayIsBodyEvent
import com.svoemesto.ivfx.utils.OverlayImage.Companion.setOverlayIsBodyScene
import com.svoemesto.ivfx.utils.OverlayImage.Companion.setOverlayIsEndEvent
import com.svoemesto.ivfx.utils.OverlayImage.Companion.setOverlayIsEndScene
import com.svoemesto.ivfx.utils.OverlayImage.Companion.setOverlayIsStartEvent
import com.svoemesto.ivfx.utils.OverlayImage.Companion.setOverlayIsStartScene
import com.svoemesto.ivfx.utils.OverlayImage.Companion.setOverlayUnderlineText
import javafx.scene.control.ContentDisplay
import javafx.scene.control.Label
import javafx.scene.image.ImageView
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.io.File as IOFile

data class ShotExt(
    val shot: Shot,
    val fileExt: FileExt,
    val firstFrameExt: FrameExt,
    val lastFrameExt: FrameExt
) {
    val start: String get() = convertDurationToString(getDurationByFrameNumber(shot.firstFrameNumber - 1, fileExt.fps))
    val end: String get() = convertDurationToString(getDurationByFrameNumber(shot.lastFrameNumber, fileExt.fps))
    val duration: Int get() = getDurationByFrameNumber(shot.lastFrameNumber - shot.firstFrameNumber + 1, fileExt.fps)
    var previewFirst: Array<ImageView?>? = null
        get() {
            if (field == null) {
                field = arrayOfNulls(3)
                var bi: BufferedImage = ImageIO.read(IOFile(if (IOFile(firstFrameExt.pathToSmall).exists()) firstFrameExt.pathToSmall else FrameExt.pathToStubSmall))
                for (i in 0..2) {
                    bi = setOverlayUnderlineText(bi, start)
                    if (shot.isBodyScene) bi = setOverlayIsBodyScene(bi)
                    if (shot.isStartScene) bi = setOverlayIsStartScene(bi)
                    if (shot.isEndScene) bi = setOverlayIsEndScene(bi)
                    field!![i] = ImageView(ConvertToFxImage.convertToFxImage(bi))
                }
            }
            return field
        }
    var previewLast: Array<ImageView?>? = null
        get() {
            if (field == null) {
                field = arrayOfNulls(3)
                var bi: BufferedImage = ImageIO.read(IOFile(if (IOFile(lastFrameExt.pathToSmall).exists()) lastFrameExt.pathToSmall else FrameExt.pathToStubSmall))
                for (i in 0..2) {
                    bi = setOverlayUnderlineText(bi, start)
                    if (shot.isBodyEvent) bi = setOverlayIsBodyEvent(bi)
                    if (shot.isStartEvent) bi = setOverlayIsStartEvent(bi)
                    if (shot.isEndEvent) bi = setOverlayIsEndEvent(bi)
                    field!![i] = ImageView(ConvertToFxImage.convertToFxImage(bi))
                }
            }
            return field
        }
    var labelFirst: Array<Label?>? = null
        get() {
            if (field == null) {
                field = arrayOfNulls(3)
                for (i in 0..2) {
                    field!![i] = Label()
                    field!![i]?.setMinSize(135.0,75.0)
                    field!![i]?.setMaxSize(135.0,75.0)
                    field!![i]?.setPrefSize(135.0,75.0)
                    field!![i]?.graphic = previewFirst?.get(i)
                    field!![i]?.contentDisplay = ContentDisplay.TOP
                }
            }
            return field
        }
    var labelLast: Array<Label?>? = null
        get() {
            if (field == null) {
                field = arrayOfNulls(3)
                for (i in 0..2) {
                    field!![i] = Label()
                    field!![i]?.setMinSize(135.0,75.0)
                    field!![i]?.setMaxSize(135.0,75.0)
                    field!![i]?.setPrefSize(135.0,75.0)
                    field!![i]?.graphic = previewLast?.get(i)
                    field!![i]?.contentDisplay = ContentDisplay.TOP
                }
            }
            return field
        }

}
package com.svoemesto.ivfx.models

import org.springframework.stereotype.Component
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Component
@Entity
@Table(name = "tbl_files_tracks")
class Track {

    @NotNull(message = "ID трека файла не может быть NULL")
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id")
    lateinit var file: File

    @Column(name = "order_file_track", nullable = false)
    var order: Int = 0

    @Column(name = "name")
    var name: String = ""

    @Column(name = "type")
    var type: String = ""

    @Column(name = "use_track")
    var use: Boolean = true

}
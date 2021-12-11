package com.svoemesto.ivfx.models

import com.svoemesto.ivfx.enums.TagType
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Component
@Entity
@Table(name = "tbl_tags_childs")
@Transactional
class TagChild {

    @NotNull(message = "ID TagChild не может быть NULL")
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    lateinit var tag: Tag

    @Column(name = "order_tag_child", nullable = false, columnDefinition = "int default 0")
    var order: Int = 0

    @Column(name = "name", columnDefinition = "varchar(255) default ''")
    var name: String = ""

    @Column(name = "child_id", columnDefinition = "int default 0")
    var childId: Long = 0

    @Column(name = "child_class", columnDefinition = "varchar(255) default ''")
    var childClass: String = ""

}
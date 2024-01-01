package com.jaemin.exec.keyword.infrastructure

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Keyword(
    @Id
    @Column(name = "keyword")
    val keyword: String,
    @Column(name = "useCount")
    val useCount: Long,
)
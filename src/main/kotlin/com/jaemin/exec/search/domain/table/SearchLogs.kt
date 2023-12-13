package com.jaemin.exec.search.domain.table

import jakarta.persistence.*

@Entity
class SearchLogs(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,
    val name: String
)
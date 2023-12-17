package com.jaemin.exec.search.infrastructure.entity

import jakarta.persistence.*

@Entity
class SearchLogs(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,
    val name: String
)
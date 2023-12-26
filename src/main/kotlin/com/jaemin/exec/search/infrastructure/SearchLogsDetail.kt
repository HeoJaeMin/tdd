package com.jaemin.exec.search.infrastructure

import jakarta.persistence.*

@Entity
class SearchLogsDetail(
    @Id
    @Column(name = "detailId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val detailId: Int?,
    @Column(name = "logId")
    var logId: Int?,
    @Column(name = "title")
    val title: String,
    @Column(name = "link")
    val link: String,
    @Column(name = "category")
    val category: String,
    @Column(name = "address")
    val address: String,
    @Column(name = "roadAddress")
    val roadAddress: String,
    @Column(name = "telephone")
    val telephone: String,
) {
    constructor(
        logId: Int?,
        title: String,
        link: String,
        category: String,
        address: String,
        roadAddress: String,
        telephone: String,
    ) : this(
        null,
        logId,
        title,
        link,
        category,
        address,
        roadAddress,
        telephone
    )
}
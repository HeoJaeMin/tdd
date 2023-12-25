package com.jaemin.exec.search.infrastructure

import jakarta.persistence.*

@Entity
class SearchLogsDetail(
    @Id
    @Column(name="detailId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val detailId: Int?,
    @Column(name="logId")
    val logId: Int,
    @Column(name="title")
    val title: String,
    @Column(name="link")
    val lint: String,
    @Column(name="category")
    val category: String,
    @Column(name="address")
    val address: String,
    @Column(name="roadAddress")
    val roadAddress: String,
    @Column(name="telephone")
    val telephone: String
) {

}
package com.jaemin.exec.search.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.Builder
import lombok.NoArgsConstructor

@Entity
@Builder
@NoArgsConstructor
class SearchLogs(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?
) {
    fun SearchLogs() {

    }
}
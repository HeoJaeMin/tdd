package com.jaemin.exec.core.response

import com.jaemin.exec.core.error.ErrorDetails

class ResponseTemplate<T>(
    val success: Boolean,
    val result: T?,
    val errorResponse: ErrorDetails?
) {
    constructor(success: Boolean, result: T?) : this(success, result, null)
    constructor(success: Boolean, errorDetails: ErrorDetails) : this(success, null, errorDetails)
}
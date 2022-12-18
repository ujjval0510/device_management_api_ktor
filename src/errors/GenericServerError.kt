package com.neci.errors

data class GenericServerError (val httpStatus: Int, val message:String)
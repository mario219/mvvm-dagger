package com.example.data.utils

/*
 * Concept taken from Blueprints example from codelabs courses:
 * https://github.com/android/architecture-samples
 */

sealed class QueryWrapper<out R> {

    data class Success<out T>(val data: T) : QueryWrapper<T>()
    data class Error(val exception: Exception) : QueryWrapper<Nothing>()
}
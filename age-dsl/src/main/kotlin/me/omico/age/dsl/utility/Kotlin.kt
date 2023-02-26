package me.omico.age.dsl.utility

import java.util.Locale

fun String.uppercase(): String = uppercase(Locale.getDefault())

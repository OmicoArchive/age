package me.omico.age

sealed class AndroidModuleType {

    object Application : AndroidModuleType()
    object Library : AndroidModuleType()
    object DynamicFeature : AndroidModuleType()
}

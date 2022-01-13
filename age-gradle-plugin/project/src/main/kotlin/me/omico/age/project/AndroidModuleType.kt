package me.omico.age.project

sealed class AndroidModuleType {

    object Application : AndroidModuleType()
    object Library : AndroidModuleType()
    object DynamicFeature : AndroidModuleType()
}

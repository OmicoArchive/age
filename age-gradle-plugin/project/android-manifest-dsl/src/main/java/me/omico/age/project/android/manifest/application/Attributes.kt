package me.omico.age.project.android.manifest.application

import me.omico.age.project.android.manifest.AndroidAttributesDelegate
import me.omico.age.project.android.manifest.ApplicationScope

// TODO we should generate these automatically via a schema

var ApplicationScope.name: String by AndroidAttributesDelegate()
var ApplicationScope.allowBackup: Boolean by AndroidAttributesDelegate()
var ApplicationScope.icon: String by AndroidAttributesDelegate()
var ApplicationScope.label: String by AndroidAttributesDelegate()
var ApplicationScope.roundIcon: String by AndroidAttributesDelegate()
var ApplicationScope.supportsRtl: Boolean by AndroidAttributesDelegate()
var ApplicationScope.theme: String by AndroidAttributesDelegate()

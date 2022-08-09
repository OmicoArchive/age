import me.omico.age.project.android.manifest
import me.omico.age.project.android.manifest.action
import me.omico.age.project.android.manifest.application
import me.omico.age.project.android.manifest.application.activity
import me.omico.age.project.android.manifest.application.allowBackup
import me.omico.age.project.android.manifest.application.name
import me.omico.age.project.android.manifest.category
import me.omico.age.project.android.manifest.data
import me.omico.age.project.android.manifest.intent
import me.omico.age.project.android.manifest.`package`
import me.omico.age.project.android.manifest.queries
import me.omico.age.project.android.manifest.`uses-feature`
import me.omico.age.project.android.manifest.`uses-permission`

fun main() {
    manifest {
        `uses-permission`("android.permission.INTERNET") // TODO use constants directly from AOSP -- android.jar.
        `uses-feature`("android.hardware.camera", false)
        queries {
            intent {
                action("android.intent.action.VIEW")
                data("otpauth")
            }
            intent {
                action("android.intent.action.VIEW")
                category("android.intent.category.BROWSABLE")
                data("https")
            }
            `package`("com.android.mms")
        }
        application {
            name = "me.omico.age.x"
            allowBackup = true
            activity("me.omico.age.Activity")
            activity {
                name = "me.omico.age.Activity"
            }
        }
    }.let { println(it) }
}

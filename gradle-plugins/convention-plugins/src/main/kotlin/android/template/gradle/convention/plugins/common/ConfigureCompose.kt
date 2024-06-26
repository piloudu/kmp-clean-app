package android.template.gradle.convention.plugins.common

import com.android.build.api.dsl.CommonExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

const val ENABLE_COMPOSE_COMPILER_REPORTS: String = "enableComposeCompilerReports"

fun Project.configureCompose(commonExtension: CommonExtension<*, *, *, *, *, *>, libs: LibrariesForLibs) {
    commonExtension.buildFeatures {
        compose = true
    }

    commonExtension.composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.androidxComposeCompiler.get()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            if (project.findProperty(ENABLE_COMPOSE_COMPILER_REPORTS) == true) {
                freeCompilerArgs += listOf(
                    "-P",
                    "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=" +
                        project.buildDir.absolutePath + "/compose_metrics",
                )
                freeCompilerArgs += listOf(
                    "-P",
                    "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=" +
                        project.buildDir.absolutePath + "/compose_metrics",
                )
            }
        }
    }
}

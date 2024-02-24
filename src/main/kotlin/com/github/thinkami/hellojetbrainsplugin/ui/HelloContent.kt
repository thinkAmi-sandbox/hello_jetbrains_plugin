package com.github.thinkami.hellojetbrainsplugin.ui

import com.intellij.ui.dsl.builder.panel
import javax.swing.JComponent

fun getHelloContent(): JComponent {
    return panel {
        row {
            label("Hello")
        }
    }
}
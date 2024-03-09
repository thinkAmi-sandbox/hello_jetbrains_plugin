package com.github.thinkami.hellojetbrainsplugin.ui

import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.dsl.builder.Cell
import com.intellij.ui.dsl.builder.panel
import com.intellij.ui.table.JBTable

class AppleTableContent {
    var contentPanel : DialogPanel
    lateinit var myTableModel: Cell<JBTable>

    init {
        contentPanel = panel {
            row {

                val table = JBTable()
                val model = AppleTableModel()
                table.model = model
                myTableModel = cell(table)
            }
        }
    }

}
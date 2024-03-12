package com.github.thinkami.hellojetbrainsplugin.ui

import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.components.JBTextField
import com.intellij.ui.dsl.builder.Cell
import com.intellij.ui.dsl.builder.panel
import com.intellij.ui.table.JBTable
import javax.swing.event.DocumentEvent
import javax.swing.event.DocumentListener

class AppleTableContent {
    var contentPanel : DialogPanel
    lateinit var myTableModel: Cell<JBTable>
    lateinit var searchText: Cell<JBTextField>
    val appleTableModel: AppleTableModel

    init {
        appleTableModel = AppleTableModel()

        contentPanel = panel {
            row {
                label("Search text")
                searchText = textField()
                searchText.component.document.addDocumentListener(object: DocumentListener {
                    override fun insertUpdate(e: DocumentEvent?) {
                        handleChange()
                    }

                    override fun removeUpdate(e: DocumentEvent?) {
                        handleChange()
                    }

                    override fun changedUpdate(e: DocumentEvent?) {
                        handleChange()
                    }
                })
            }
            row {
                val table = JBTable()
                table.model = appleTableModel
                table.columnModel.getColumn(2).cellRenderer = AppleTableCellRenderer()
                myTableModel = scrollCell(table)
            }
        }
    }

    private fun handleChange() {
        appleTableModel.tableFilter.filterText = searchText.component.text
    }
}
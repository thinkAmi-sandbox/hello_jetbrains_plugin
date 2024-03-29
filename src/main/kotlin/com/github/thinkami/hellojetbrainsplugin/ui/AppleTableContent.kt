package com.github.thinkami.hellojetbrainsplugin.ui

import com.github.thinkami.hellojetbrainsplugin.actions.SettingsAction
import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.SearchTextField
import com.intellij.ui.dsl.builder.Cell
import com.intellij.ui.dsl.builder.panel
import com.intellij.ui.table.JBTable
import javax.swing.event.DocumentEvent
import javax.swing.event.DocumentListener

class AppleTableContent {
    var contentPanel : DialogPanel
    lateinit var myTableModel: Cell<JBTable>
    lateinit var searchText: Cell<SearchTextField>
    val appleTableModel: AppleTableModel

    init {
        appleTableModel = AppleTableModel()

        contentPanel = panel {
            row {
                button("Settings", SettingsAction())
            }
            row {
                label("Search text")
                searchText = cell(SearchTextField())
                searchText.component.addDocumentListener(object: DocumentListener {
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
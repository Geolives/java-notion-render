package com.geolives.entities.blocks;

import com.geolives.entities.blocks.richtexts.RichText;
import com.geolives.entities.enums.BlockType;

public class TableRowBlock extends Block {

    private TableRow tableRow;

    public TableRowBlock() {
        super(BlockType.TABLE_ROW);
    }

    public TableRow getTableRow() {
        return this.tableRow;
    }

    public void setTableRow(final TableRow tableRow) {
        this.tableRow = tableRow;
    }

    public class TableRow {
        private RichText[][] cells;

        public TableRow() {}

        public RichText[][] getCells() {
            return this.cells;
        }

        public void setCells(final RichText[][] cells) {
            this.cells = cells;
        }
    }
}

package com.geolives.entities.blocks;

import com.geolives.entities.enums.BlockType;

public class TableBlock extends Block {

    private Table table;

    public TableBlock() {
        super(BlockType.TABLE);
    }

    public Table getTable() {
        return this.table;
    }

    public void setTable(final Table table) {
        this.table = table;
    }

    private class Table {
        private int tableWidth;
        private boolean hasColumnHeader;
        private boolean hasRowHeader;

        public Table() {}

        public int getTableWidth() {
            return this.tableWidth;
        }

        public void setTableWidth(final int tableWidth) {
            this.tableWidth = tableWidth;
        }

        public boolean isHasColumnHeader() {
            return this.hasColumnHeader;
        }

        public void setHasColumnHeader(final boolean hasColumnHeader) {
            this.hasColumnHeader = hasColumnHeader;
        }

        public boolean isHasRowHeader() {
            return this.hasRowHeader;
        }

        public void setHasRowHeader(final boolean hasRowHeader) {
            this.hasRowHeader = hasRowHeader;
        }
    }
}

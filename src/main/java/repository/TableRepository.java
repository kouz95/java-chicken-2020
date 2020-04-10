package repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.EmptyTable;
import domain.Table;

public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();

    static {
        tables.add(new EmptyTable(1));
        tables.add(new EmptyTable(2));
        tables.add(new EmptyTable(3));
        tables.add(new EmptyTable(5));
        tables.add(new EmptyTable(6));
        tables.add(new EmptyTable(8));
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }
}

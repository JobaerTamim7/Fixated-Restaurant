package org.example.controllers.admin;


import io.github.palexdev.materialfx.controls.MFXTableColumn;
import io.github.palexdev.materialfx.controls.MFXTableView;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import io.github.palexdev.materialfx.filter.StringFilter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import org.example.models.user.TableUser;
import org.example.services.ManagerTableService;


public class AllUserController {
    @FXML private MFXTableView<TableUser> userTable;

    private ObservableList<TableUser> users;

    public void initialize() {
        setupTable();
        loadData();
    }

    private void setupTable() {

        MFXTableColumn<TableUser> idColumn = new MFXTableColumn<>("ID", true);
        idColumn.setRowCellFactory(TableUser -> new MFXTableRowCell<>(u->TableUser.getWorker_id()));

        MFXTableColumn<TableUser> nameColumn = new MFXTableColumn<>("Name", true);
        nameColumn.setRowCellFactory(TableUser -> new MFXTableRowCell<>(u->TableUser.getName()));

        MFXTableColumn<TableUser> emailColumn = new MFXTableColumn<>("Email", true);
        emailColumn.setRowCellFactory(TableUser -> new MFXTableRowCell<>(u->TableUser.getMail()));

        MFXTableColumn<TableUser> phoneColumn = new MFXTableColumn<>("Phone", true);
        phoneColumn.setRowCellFactory(TableUser -> new MFXTableRowCell<>(u->TableUser.getPhone_number()));

        MFXTableColumn<TableUser> branchColumn = new MFXTableColumn<>("Branch", true);
        branchColumn.setRowCellFactory(TableUser -> new MFXTableRowCell<>(u->TableUser.getBranch_code()));

        userTable.getTableColumns().addAll(idColumn, nameColumn, emailColumn, phoneColumn, branchColumn);


        userTable.getFilters().add(new StringFilter<>("Name", TableUser::getName));
        userTable.getFilters().add(new StringFilter<>("Email", TableUser::getMail));
        userTable.getFilters().add(new StringFilter<>("ID", TableUser::getWorker_id));
    }

    private void loadData() {
        ManagerTableService.fetchData(userTable);
    }

}



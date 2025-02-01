package org.example.controllers.admin;


import io.github.palexdev.materialfx.controls.MFXTableColumn;
import io.github.palexdev.materialfx.controls.MFXTableView;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import io.github.palexdev.materialfx.filter.StringFilter;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import org.example.models.user.ManagerTableUser;
import org.example.services.admin.ManagerTableService;


public class AllUserController {
    @FXML private MFXTableView<ManagerTableUser> userTable;

    private ObservableList<ManagerTableUser> users;

    public void initialize() {
        setupTable();
        loadData();
    }

    private void setupTable() {

        MFXTableColumn<ManagerTableUser> idColumn = new MFXTableColumn<>("ID", true);
        idColumn.setRowCellFactory(ManagerTableUser -> new MFXTableRowCell<>(u-> ManagerTableUser.getWorker_id()));

        MFXTableColumn<ManagerTableUser> nameColumn = new MFXTableColumn<>("Name", true);
        nameColumn.setRowCellFactory(ManagerTableUser -> new MFXTableRowCell<>(u-> ManagerTableUser.getName()));

        MFXTableColumn<ManagerTableUser> emailColumn = new MFXTableColumn<>("Email", true);
        emailColumn.setRowCellFactory(ManagerTableUser -> new MFXTableRowCell<>(u-> ManagerTableUser.getMail()));

        MFXTableColumn<ManagerTableUser> phoneColumn = new MFXTableColumn<>("Phone", true);
        phoneColumn.setRowCellFactory(ManagerTableUser -> new MFXTableRowCell<>(u-> ManagerTableUser.getPhone_number()));

        MFXTableColumn<ManagerTableUser> branchColumn = new MFXTableColumn<>("Branch", true);
        branchColumn.setRowCellFactory(ManagerTableUser -> new MFXTableRowCell<>(u-> ManagerTableUser.getBranch_code()));

        userTable.getTableColumns().addAll(idColumn, nameColumn, emailColumn, phoneColumn, branchColumn);


        userTable.getFilters().add(new StringFilter<>("Name", ManagerTableUser::getName));
        userTable.getFilters().add(new StringFilter<>("Email", ManagerTableUser::getMail));
        userTable.getFilters().add(new StringFilter<>("ID", ManagerTableUser::getWorker_id));
    }

    private void loadData() {
        ManagerTableService.fetchData(userTable);
    }

}



package Auth;

import java.util.List;
import java.util.Map;

public class trueResponse {

    public List<organisationList> getOrganisationList() {
        return organisationList;
    }

    public void setOrganisationList(List<organisationList> organisationList) {
        this.organisationList = organisationList;
    }

    public userDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(userDTO userDTO) {
        this.userDTO = userDTO;
    }

    public List<permissionDetailList> getPermissionDetailList() {
        return permissionDetailList;
    }

    public void setPermissionDetailList(List<permissionDetailList> permissionDetailList) {
        this.permissionDetailList = permissionDetailList;
    }

    public data getData() {
        return data;
    }

    public void setData(data data) {
        this.data = data;
    }

    public warehouseList getWarehouseList() {
        return warehouseList;
    }

    public void setWarehouseList(warehouseList warehouseList) {
        this.warehouseList = warehouseList;
    }
    private String _200 ;
   private Map<String,warehouseList> warehouseList;
   private data data;
   private List<permissionDetailList> permissionDetailList;
   private userDTO userDTO;
   private List<organisationList> organisationList;

}

package amusementparkvisit.specification;


/**
 * @title: StaffRoleSpecification
 * @Author Kexian Tang
 * @Date: 2023/12/15
 * @Version 1.0
 */
/**
 * 员工角色规约
 */
public class StaffRoleSpecification extends CompositeSpecification<Staff> {
    private String requiredRole;

    public StaffRoleSpecification(String requiredRole) {
        this.requiredRole = requiredRole;
    }

    @Override
    public boolean isSatisfiedBy(Staff staff) {
        return staff.getRole().equalsIgnoreCase(requiredRole);
    }
}

package amusementparkvisit.test;

import amusementparkvisit.specification.*;

/**
 * @title: SpecificationPatternTest
 * @Author Kexian Tang
 * @Date: 2023/12/15
 * @Version 1.0
 */
public class SpecificationPatternTest {
    public static void main(String[] args) {
        // 创建规约
        ISpecification<Visitor> ageSpecification = new VisitorAgeSpecification(12, 18);
        ISpecification<Staff> roleSpecification = new StaffRoleSpecification("Security");

        // 测试游客规约
        Visitor youngVisitor = new Visitor("小明", 16);
        System.out.println("年龄在12到18岁的游客是否可以进入青少年游乐区域：" + ageSpecification.isSatisfiedBy(youngVisitor));

        // 测试员工规约
        Staff securityStaff = new Staff("王警官", "Security");
        System.out.println("保安是否可以进入员工仅限区域：" + roleSpecification.isSatisfiedBy(securityStaff));
    }
}
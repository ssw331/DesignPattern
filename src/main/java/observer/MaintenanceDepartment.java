package observer;

class MaintenanceDepartment implements Observer {
    @Override
    public void update(String facilityName, String status) {
        if ("故障".equals(status)) {
            System.out.println("维修部门收到 " + facilityName + " 故障的通知，正在前往维修...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("维修部门已完成维修");
        }
    }

}

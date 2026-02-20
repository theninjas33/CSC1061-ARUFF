abstract class FinancialInstitution
        implements Comparable<FinancialInstitution>, Cloneable {

    private String fiName;
    private long fiId;
    private long routingNumber;
    private Address address;

    public FinancialInstitution(String name) {
        this.fiName = name;
    }

    public String getFiName() {
        return fiName;
    }

    public void setFiName(String fiName) {
        this.fiName = fiName;
    }

    public long getFiId() {
        return fiId;
    }

    public void setFiId(long fiId) {
        this.fiId = fiId;
    }

    public long getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(long routingNumber) {
        this.routingNumber = routingNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public abstract double getInterestRate();

    @Override
    public int compareTo(FinancialInstitution o) {
        return Long.compare(this.fiId, o.fiId);
    }

    // ⭐ FIXED CLONE METHOD
    @Override
    public FinancialInstitution clone() throws CloneNotSupportedException {
        FinancialInstitution copy = (FinancialInstitution) super.clone();

        if (this.address != null) {
            copy.address = this.address.clone(); // deep copy
        }

        return copy;
    }

    @Override
    public String toString() {
        return "FinancialInstitution [fiName=" + fiName +
               ", fiId=" + fiId +
               ", routingNumber=" + routingNumber + "]";
    }
}

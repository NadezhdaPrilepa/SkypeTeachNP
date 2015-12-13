package skype.teach.vb;

/**
 * @author NPrilepa
 */
public class VbJavaBeanTeach {
    private boolean active;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof VbJavaBeanTeach)) {
            return false;
        }
        VbJavaBeanTeach jbt = (VbJavaBeanTeach) object;
        if (jbt.getName().equals(this.getName())) {
            if (jbt.isActive() == this.isActive()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = (active ? 1 : 0);
        result = 31 * result + name.hashCode();
        return result;
    }
}

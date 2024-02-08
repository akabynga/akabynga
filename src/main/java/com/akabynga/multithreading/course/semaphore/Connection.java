package com.akabynga.multithreading.course.semaphore;

import java.util.Objects;

public class Connection {

    private final long id;
    private boolean autoCommit;

    public Connection(final long id, final boolean autoCommit) {
        this.id = id;
        this.autoCommit = autoCommit;
    }

    public long getId() {
        return this.id;
    }

    public void setAutoCommit(final boolean autoCommit) {
        this.autoCommit = autoCommit;
    }

    public boolean isAutoCommit() {
        return autoCommit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Connection other = (Connection) obj;

        return this.id == other.id && this.autoCommit == other.autoCommit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, autoCommit);
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "[id = " + id + ", autoCommit = " + autoCommit + "]";
    }
}

package entities;

import java.io.Serializable;

public interface IEntity extends Serializable {
    long getId();
    String getDescription();
}

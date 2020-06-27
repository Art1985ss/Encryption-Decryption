interface Movable {
    int getX();

    int getY();

    void setX(int newX);

    void setY(int newY);
}

interface Storable {
    int getInventoryLength();

    String getInventoryItem(int index);

    void setInventoryItem(int index, String item);
}

interface Command {
    void execute();

    void undo();
}

class CommandMove implements Command {
    Movable entity;
    int xMovement;
    int yMovement;
    int xOld;
    int yOld;

    @Override
    public void execute() {
        this.xOld = entity.getX();
        this.yOld = entity.getY();
        this.entity.setX(xOld + xMovement);
        this.entity.setY(yOld + yMovement);
    }

    @Override
    public void undo() {
        this.entity.setX(xOld);
        this.entity.setY(yOld);
    }
}

class CommandPutItem implements Command {
    Storable entity;
    String item;
    int index = -1;
    String oldItem;

    @Override
    public void execute() {
        for (int i = 0; i < this.entity.getInventoryLength(); i++) {
            if (this.entity.getInventoryItem(i) == null) {
                this.oldItem = this.entity.getInventoryItem(i);
                this.index = i;
                this.entity.setInventoryItem(i, this.item);
                break;
            }
        }
    }

    @Override
    public void undo() {
        if (index >= 0) {
            this.entity.setInventoryItem(index, oldItem);
        }
    }
}
package design_structure_assembly;

import java.util.List;

public interface IFile {
    void display();
    boolean add(IFile iFile);
    boolean remove(IFile iFile);
    List<IFile> getChildren();
}

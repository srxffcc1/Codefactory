package com.business;

/**
 * Created by King6rf on 2017/5/25.
 */
public class ModuleView {
    public String modulename;
    public String moduleimage;
    public String moduleclass;

    public ModuleView(String modulename, String moduleimage, String moduleclass) {
        this.modulename = modulename;
        this.moduleimage = moduleimage;
        this.moduleclass = moduleclass;
    }

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename;
    }

    public String getModuleimage() {
        return moduleimage;
    }

    public void setModuleimage(String moduleimage) {
        this.moduleimage = moduleimage;
    }

    public String getModuleclass() {
        return moduleclass;
    }

    public void setModuleclass(String moduleclass) {
        this.moduleclass = moduleclass;
    }
}

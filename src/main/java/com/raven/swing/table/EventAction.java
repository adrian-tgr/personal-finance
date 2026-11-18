package com.raven.swing.table;

import com.raven.model.ModelTransaction;

public interface EventAction {

    public void delete(ModelTransaction transaction);

    public void update(ModelTransaction transaction);
}
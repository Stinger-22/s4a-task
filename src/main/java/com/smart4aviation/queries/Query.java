package com.smart4aviation.queries;

import com.smart4aviation.airport.capacity.CapacityTable;

/**
 * Interface for queries which are supposed to be executed on provided <code>CapacityTable</code>.
 */
public interface Query {

    /**
     * <p>Provide table on which the query will be performed.</p>
     * @param capacityTable on which query will perform action.
     */
    void setCapacityTable(CapacityTable capacityTable);

    /**
     * <p>Execute query on provided instance of <code>CapacityTable</code>.</p>
     */
    void execute();
}

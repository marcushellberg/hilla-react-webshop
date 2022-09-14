import * as React from 'react';
import {Avatar, Grid, GridColumn} from "react-vaadin-components";
import {useEffect, useState} from "react";
import {CustomersEndpoint} from "Frontend/generated/endpoints";
import {useNavigate} from "react-router-dom";
import Customer from "Frontend/generated/com/example/application/data/entity/Customer";

export function Customers(): React.ReactElement {

  const [customers, setCustomers] = useState<Customer[]>([]);
  const navigate = useNavigate();

  async function fetchCustomers() {
    setCustomers(await CustomersEndpoint.getCustomers());
  }

  useEffect(() => {
    fetchCustomers();
  }, []);


  return (
    <div className="m-xl">
      <h2 className="text-xl my-xl">Customers</h2>
      <Grid items={customers} onClick={e => {
        const {item} = e.currentTarget.getEventContext(e.nativeEvent);
        if (item) {
          navigate(`/customers/${item.id}`)
        }
      }}>
        <GridColumn path="added"
                    header="Date added"
                    autoWidth
                    itemRenderer={({item}) => <span>{new Date(item.added).toDateString()}</span>}/>
        <GridColumn path="name"
                    autoWidth
                    itemRenderer={({item}) => <Avatar name={item.name} />}/>
        <GridColumn path="email" autoWidth/>
        <GridColumn path="orderCount" autoWidth/>
      </Grid>
    </div>
  );
}

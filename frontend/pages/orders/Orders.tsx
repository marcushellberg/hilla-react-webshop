import * as React from 'react';
import { useEffect, useState } from 'react';
import { Avatar, Grid, GridColumn } from 'react-vaadin-components';
import { OrdersEndpoint } from 'Frontend/generated/endpoints';
import "./Order.css";
import {useNavigate} from "react-router-dom";
import OrderDTO from "Frontend/generated/com/example/application/data/dto/OrderDTO";

export function Orders(): React.ReactElement {
  const navigate = useNavigate();
  const [orders, setOrders] = useState(Array<OrderDTO>());

  useEffect(() => {
    (async () => {
      setOrders(await OrdersEndpoint.getOrders());
    })();

    return () => {};
  }, []);

  return (
    <div className="box-border flex flex-col p-m gap-s w-full h-full">
      <div className="content flex gap-m h-full">
        <Grid className="h-full" items={orders} onClick={e => {
          const {item} = e.currentTarget.getEventContext(e.nativeEvent);
          if (item) {
            navigate(`/orders/${item.id}`)
          }
        }}>
          <GridColumn
            path="orderNumber"
            header="Order"
            autoWidth
            itemRenderer={({ item }) => <span>#{item.orderNumber}</span>}
          />
          <GridColumn
            path="added"
            header="Date added"
            autoWidth
            itemRenderer={({ item }) => <span>{new Date(item.added).toDateString()}</span>}
          />
          <GridColumn
            path="customer.name"
            header="Customer"
            autoWidth
            itemRenderer={({ item }) => (
              <div className="customer-name">
                <Avatar name={item.customer.name} />
                <span>{item.customer.name}</span>
              </div>
            )}
          />
          <GridColumn path="fulfillment" header="Fulfillment" autoWidth />
          <GridColumn path="paymentStatus" header="Payment status" autoWidth />
          <GridColumn path="total" header="Total" autoWidth />
          <GridColumn path="currency" header="" autoWidth />
        </Grid>
      </div>
    </div>
  );
}

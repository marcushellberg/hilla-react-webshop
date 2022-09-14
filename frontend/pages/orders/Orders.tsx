import * as React from 'react';
import {useEffect, useState} from 'react';
import {Avatar, Grid, GridColumn} from "react-vaadin-components";
import {OrdersEndpoint} from "Frontend/generated/endpoints";
import Order from "Frontend/generated/com/example/application/data/entity/Order";

export function Orders(): React.ReactElement {
    const [orders, setOrders] = useState(Array<Order>());

    useEffect(() => {
        (async () => {
            const fetchedOrders = await OrdersEndpoint.getOrders();
            setOrders(fetchedOrders);
        })();

        return () => {
        };
    }, []);

    return (
        <div className="box-border flex flex-col p-m gap-s w-full h-full">
            <div className="content flex gap-m h-full">
                <Grid
                    className="h-full"
                    items={orders}>
                    <GridColumn path="orderNumber" header="Order" autoWidth
                                itemRenderer={({item}) => <span>#{item.orderNumber}</span>}/>
                    <GridColumn path="added" header="Date added" autoWidth
                                itemRenderer={({item}) => <span>{new Date(item.added).toDateString()}</span>}/>
                    <GridColumn path="customer.name" header="Customer" autoWidth
                                itemRenderer={({item}) => <span><Avatar name={item.customer.name}/> {item.customer.name}</span>}/>
                    <GridColumn path="fulfillment" header="Fulfillment" autoWidth/>
                    <GridColumn path="paymentStatus" header="Payment status" autoWidth/>
                    <GridColumn path="total" header="Total" autoWidth/>
                    <GridColumn path="currency" header="" autoWidth/>
                </Grid>
            </div>
        </div>
    )
}

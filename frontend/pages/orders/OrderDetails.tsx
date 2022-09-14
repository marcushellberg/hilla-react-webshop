import * as React from "react";
import {useEffect, useState} from "react";
import Order from "Frontend/generated/com/example/application/data/entity/Order";
import {OrdersEndpoint} from "Frontend/generated/endpoints";
import {useLocation, useParams} from "react-router-dom";

export function OrderDetails(): React.ReactElement {
    let { id } = useParams<'id'>();
    const location = useLocation();
    const [order, setOrder] = useState({} as Order);

    useEffect(() => {
        (async () => {
            setOrder(await OrdersEndpoint.getOrderById(id!));
        })();

        return () => {
        };
    }, []);

    return (
      <div>#{order.orderNumber}</div>
    );
}

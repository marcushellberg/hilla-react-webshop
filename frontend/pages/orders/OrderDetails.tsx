import * as React from "react";
import {useEffect, useState} from "react";
import {OrdersEndpoint} from "Frontend/generated/endpoints";
import {useLocation, useParams} from "react-router-dom";
import OrderDTO from "Frontend/generated/com/example/application/data/dto/OrderDTO";

export function OrderDetails(): React.ReactElement {
    let { id } = useParams<'id'>();
    const location = useLocation();
    const [order, setOrder] = useState({} as OrderDTO);

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

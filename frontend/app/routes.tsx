import { CustomersIcon } from 'Frontend/pages/customers/CustomersIcon.js';
import { Customers } from 'Frontend/pages/customers/index.js';
import { DiscountsIcon } from 'Frontend/pages/discounts/DiscountsIcon.js';
import { Discounts } from 'Frontend/pages/discounts/index.js';
import { GiftCardsIcon } from 'Frontend/pages/giftcards/GiftCardsIcon.js';
import { GiftCards } from 'Frontend/pages/giftcards/index.js';
import { Orders } from 'Frontend/pages/orders/index.js';
import { OrdersIcon } from 'Frontend/pages/orders/OrdersIcon.js';
import { Pricing } from 'Frontend/pages/pricing/index.js';
import { PricingIcon } from 'Frontend/pages/pricing/PricingIcon.js';
import { NewProduct, Products } from 'Frontend/pages/products/index.js';
import { ProductsIcon } from 'Frontend/pages/products/ProductsIcon.js';
import { Settings } from 'Frontend/pages/settings/index.js';
import { SettingsIcon } from 'Frontend/pages/settings/SettingsIcon.js';
import React from 'react';
import { Outlet, RouteObject } from 'react-router-dom';

export type ExtendedRouteObject = Omit<RouteObject, 'children'> & {
  children: ExtendedRouteObject[];
  name: string;
  icon: React.ReactElement;
  displayInMenu?: boolean;
};

export default [
  { path: 'orders', name: 'Orders', element: <Orders />, icon: <OrdersIcon /> },
  {
    path: 'products',
    name: 'Products',
    icon: <ProductsIcon />,
    children: [
      {
        path: '',
        name: 'Products',
        element: <Products />,
      },
      {
        path: 'new',
        name: 'New Product',
        element: <NewProduct />,
      },
    ],
  },
  {
    path: 'customers',
    name: 'Customers',
    element: <Customers />,
    icon: <CustomersIcon />,
  },
  {
    path: 'discounts',
    name: 'Discounts',
    element: <Discounts />,
    icon: <DiscountsIcon />,
  },
  {
    path: 'gift-cards',
    name: 'Gift Cards',
    element: <GiftCards />,
    icon: <GiftCardsIcon />,
  },
  {
    path: 'pricing',
    name: 'Pricing',
    element: <Pricing />,
    icon: <PricingIcon />,
  },
  {
    path: 'settings',
    name: 'Settings',
    element: <Settings />,
    icon: <SettingsIcon />,
  },
] as ExtendedRouteObject[];

export type RouteDescription = Readonly<{
  children?: Readonly<Record<string, RouteDescription>>;
  element: React.ReactElement;
  icon?: React.ReactNode;
  text: string;
}>;

// export default {
//   orders: { element: <Orders />, icon: <OrdersIcon />, text: 'Orders' },
//   products: {
//     children: {
//       new: {
//         element: <NewProduct />,
//         text: 'New Product',
//       },
//     },
//     element: <Products />,
//     icon: <ProductsIcon />,
//     text: 'Products',
//   },
//   customers: { element: <Customers />, icon: <CustomersIcon />, text: 'Customers' },
//   discounts: { element: <Discounts />, icon: <DiscountsIcon />, text: 'Discounts' },
//   'gift-cards': { element: <GiftCards />, icon: <GiftCardsIcon />, text: 'Gift Cards' },
//   pricing: { element: <Pricing />, icon: <PricingIcon />, text: 'Pricing' },
//   settings: { element: <Settings />, icon: <SettingsIcon />, text: 'Settings' },
// } as Readonly<Record<string, RouteDescription>>;

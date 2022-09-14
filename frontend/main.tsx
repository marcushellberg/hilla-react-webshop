import { Customers } from 'Frontend/pages/customers/index.js';
import { GiftCards } from 'Frontend/pages/giftcards/index.js';
import { Orders } from 'Frontend/pages/orders/index.js';
import { Pricing } from 'Frontend/pages/pricing/index.js';
import { NewProduct, Products } from 'Frontend/pages/products/index.js';
import { Settings } from 'Frontend/pages/settings/index.js';
import React from 'react';
import { createRoot } from 'react-dom/client';
import App from './app/App';
import './index.css';
import 'react-vaadin-components/dist/css/core.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { Discounts } from './pages/discounts';

const container = document.getElementById('root');
const root = createRoot(container!);

root.render(
  <React.StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<App />}>
          <Route path="customers" element={<Customers />}></Route>
          <Route path="discounts" element={<Discounts />}></Route>
          <Route path="gift-cards" element={<GiftCards />}></Route>
          <Route path="orders" element={<Orders />}></Route>
          <Route path="pricing" element={<Pricing />}></Route>
          <Route path="products" element={<Products />}></Route>
          <Route path="products/new" element={<NewProduct />}></Route>
          <Route path="settings" element={<Settings />}></Route>
        </Route>
      </Routes>
    </BrowserRouter>
  </React.StrictMode>
);

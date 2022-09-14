import React from 'react';
import { createRoot } from 'react-dom/client';
import App from './app/App';
import './index.css';
import 'react-vaadin-components/dist/css/core.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

const container = document.getElementById('root');
const root = createRoot(container!);

root.render(
  <React.StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<App />}></Route>
      </Routes>
    </BrowserRouter>
  </React.StrictMode>
);

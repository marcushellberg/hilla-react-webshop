import routes from 'Frontend/app/routes.js';
import React from 'react';
import { createRoot } from 'react-dom/client';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import 'react-vaadin-components/dist/css/core.css';
import App from './app/App';
import './index.css';

const container = document.getElementById('root');
const root = createRoot(container!);
const router = createBrowserRouter([
  {
    path: '/',
    element: <App />,
    children: Object.entries(routes).map(([path, { element }]) => ({
      path,
      element,
    })),
  },
]);

root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
);

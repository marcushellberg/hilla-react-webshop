import routes, { RouteDescription } from 'Frontend/app/routes.js';
import React from 'react';
import { createRoot } from 'react-dom/client';
import { createBrowserRouter, RouteObject, RouterProvider } from 'react-router-dom';
import 'react-vaadin-components/dist/css/core.css';
import App from './app/App';
import './index.css';

const container = document.getElementById('root');
const root = createRoot(container!);

function processRoutes(map: Readonly<Record<string, RouteDescription>>): RouteObject[] {
  return Object.entries(map).map(([path, { children, element }]) => ({
    children: children ? processRoutes(children) : undefined,
    element,
    path,
  }));
}

console.log(processRoutes(routes));

const router = createBrowserRouter([
  {
    path: '/',
    element: <App />,
    children: processRoutes(routes),
  },
]);

root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
);

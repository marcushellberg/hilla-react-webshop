import React from 'react';
import { AppLayout, DrawerToggle } from 'react-vaadin-components';
import { NavLink, Outlet } from 'react-router-dom';

function App() {
  return (
    <AppLayout>
      <header slot="navbar" className="flex gap-m items-center">
        <DrawerToggle />
        <h1 className="m-0 text-l">Hilla Cool Webshop</h1>
      </header>

      <nav slot="drawer">
        <ul className="list-none"></ul>
      </nav>

      <Outlet />
    </AppLayout>
  );
}

export default App;

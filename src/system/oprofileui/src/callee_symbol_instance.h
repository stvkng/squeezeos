/*
 * OProfile User Interface
 *
 * Copyright (C) 2007 Nokia Corporation. All rights reserved.
 *
 * Author: Robert Bradford <rob@openedhand.com>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * version 2 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA
 *
 */


#ifndef _CALLEE_SYMBOL_INSTANCE
#define _CALLEE_SYMBOL_INSTANCE

#include <glib-object.h>
#include "types.h"
#include "callee_symbol_instance.h"
#include "symbol_instance.h"

G_BEGIN_DECLS

#define TYPE_CALLEE_SYMBOL_INSTANCE callee_symbol_instance_get_type()

#define CALLEE_SYMBOL_INSTANCE(obj) \
  (G_TYPE_CHECK_INSTANCE_CAST ((obj), \
  TYPE_CALLEE_SYMBOL_INSTANCE, CalleeSymbolInstance))

#define CALLEE_SYMBOL_INSTANCE_CLASS(klass) \
  (G_TYPE_CHECK_CLASS_CAST ((klass), \
  TYPE_CALLEE_SYMBOL_INSTANCE, CalleeSymbolInstanceClass))

#define IS_CALLEE_SYMBOL_INSTANCE(obj) \
  (G_TYPE_CHECK_INSTANCE_TYPE ((obj), \
  TYPE_CALLEE_SYMBOL_INSTANCE))

#define IS_CALLEE_SYMBOL_INSTANCE_CLASS(klass) \
  (G_TYPE_CHECK_CLASS_TYPE ((klass), \
  TYPE_CALLEE_SYMBOL_INSTANCE))

#define CALLEE_SYMBOL_INSTANCE_GET_CLASS(obj) \
  (G_TYPE_INSTANCE_GET_CLASS ((obj), \
  TYPE_CALLEE_SYMBOL_INSTANCE, CalleeSymbolInstanceClass))

struct _CalleeSymbolInstance {
  SymbolInstance parent;
  gboolean is_self;
};

typedef struct {
  SymbolInstanceClass parent_class;
} CalleeSymbolInstanceClass;

GType callee_symbol_instance_get_type (void);

CalleeSymbolInstance* callee_symbol_instance_new (void);

G_END_DECLS

#endif /* _CALLEE_SYMBOL_INSTANCE */
